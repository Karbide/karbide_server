package com.bluoh.service.impl;

import com.bluoh.model.Media;
import com.bluoh.repository.MediaRepository;
import com.bluoh.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final MediaRepository repository;
    private final Environment env;

	@Autowired
    public ImageServiceImpl(MediaRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public List<Media> upload(MultipartFile[] files,String source) {
        List<Media> medias = null;
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        List<String> tempFileNames = new ArrayList<>();
        String tempFileName;
        FileOutputStream fo;
        try {
            for (MultipartFile file : files) {
                System.out.println("File Name" + file.getOriginalFilename()+ ", Size:"+file.getSize());
                tempFileName = env.getProperty("image.path") + file.getOriginalFilename();
                tempFileNames.add(tempFileName);
                fo = new FileOutputStream(tempFileName);
                fo.write(file.getBytes());
                fo.close();
                map.add("file", new FileSystemResource(tempFileName));
            }
            map.add("source", source);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(map, headers);

            ResponseEntity<List<String>> response =
                    restTemplate.exchange(env.getProperty("image.url")+"Media-1.0-SNAPSHOT/image/upload",
                            HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<String>>(){});

            if (response != null && response.getBody().size() != 0) {
                medias = new ArrayList<>();
                for( String image : response.getBody()) {
                    Media media = new Media();
                    media.setMediaCredit(source);
                    media.setMediaType("image");
                    media.setMediaUrl(env.getProperty("image.url") + "image/" + image);
                    System.out.println("ImageServiceImpl.upload " + image);
                    repository.save(media);
                    medias.add(media);
                }
            }

            for (String fileName : tempFileNames) {
                File f = new File(fileName);
                f.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medias;
	}

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public String update(MultipartFile file, String path) {
		
		if (!file.isEmpty()) {
            path = path.split("/")[4];
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            String tempFileName;
            FileOutputStream fo;
			try {
                tempFileName = env.getProperty("image.path") + file.getOriginalFilename();
                LOGGER.info(tempFileName+" : "+ path);
                fo = new FileOutputStream(tempFileName);
                fo.write(file.getBytes());
                fo.close();
                map.add("file", new FileSystemResource(tempFileName));
                map.add("url", path);

                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                HttpEntity<MultiValueMap<String, Object>> requestEntity =
                        new HttpEntity<>(map, headers);

                ResponseEntity<Map<String, String>> response =
                        restTemplate.exchange(env.getProperty("image.url")+"Media-1.0-SNAPSHOT/image/update",
                                HttpMethod.POST, requestEntity,new ParameterizedTypeReference<Map<String, String>>(){});

                File f = new File(tempFileName);
                f.delete();
                if (response != null && response.getBody().size() != 0) {
                   return response.getBody().get("message");
                }

				LOGGER.info("Success!");
                return "unexpected error";
			} catch (Exception e) {
				LOGGER.error("Failure... " + e.getMessage());
				return "file updation failed";
			}
		} else {
			LOGGER.info("file is empty");
			return "empty file";
		}
	}
}