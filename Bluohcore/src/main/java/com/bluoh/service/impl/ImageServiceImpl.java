package com.bluoh.service.impl;

import com.bluoh.model.Media;
import com.bluoh.repository.MediaRepository;
import com.bluoh.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ImageServiceImpl implements ImageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);
	private final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random rnd = new Random();
    private int randomLength = 8;

	private final MediaRepository repository;
	@Autowired
	private Environment env;

	@Autowired
	public ImageServiceImpl(MediaRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Media> upload(MultipartFile[] files,String source) {
		MultipartFile file;
		String name;
		String path;
		List<Media> response = new ArrayList<Media>();

		for (int i = 0; i < files.length; i++) {
			Media media = new Media();
			media.setType("image");
			media.setSource(source);
			file = files[i];

			name = randomString(randomLength);
			/*List<String> nameExists = repository.findByName(name);
			while (nameExists.size() > 0) {
				name = randomString(randomLength);
				nameExists = repository.findByName(name);
			}*/

			path = env.getProperty("image.path") + name+ ".png";
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
					stream.write(bytes);
					stream.close();
					LOGGER.info("Success!");
					media.setUrl(env.getProperty("image.url") + name+ ".png");
					media  = repository.save(media);
					response.add(media);
				} catch (Exception e) {
					LOGGER.error("Failure... " + e.getMessage());
				}
			} else {
				LOGGER.info("file is empty");
			}
		}
		
		return response;
	}

	@Override
	public String upload(MultipartFile file, String path) {
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
				stream.write(bytes);
				stream.close();
				LOGGER.info("Success!");
				return "successfully updated";
			} catch (Exception e) {
				LOGGER.error("Failure... " + e.getMessage());
				return "failed updated";
			}
		} else {
			LOGGER.info("file is empty");
			return "empty file";
		}
	}
	
	private String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}
