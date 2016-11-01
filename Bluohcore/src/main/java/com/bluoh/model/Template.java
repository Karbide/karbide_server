package com.bluoh.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public final class Template {

    @Id
    private String id;
    private String type;
    private String desciption;
    private Media media;
    private Content content;
    private Title title;
    private DisplayName displayName;
//    private String tapPosition;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDesciption() {
        return desciption;
    }

    public Media getMedia() {
        return media;
    }

    public Content getContent() {
        return content;
    }

    public Title getTitle() {
        return title;
    }

    public DisplayName getDisplayName() {
        return displayName;
    }

//    public String getTapPosition() {
//        return tapPosition;
//    }

    class Media {
//        private String type;
        private String space;
        private String position;
        private String mediaCredit;

//        public String getType() {
//            return type;
//        }

        public String getSpace() {
            return space;
        }

        public String getPosition() {
            return position;
        }

        public String getMediaCredit() {
            return mediaCredit;
        }
    }

    class Content {
        private String space;
        private String alignment;
        private String position;
        private FontAttributes fontAttributes;

        public String getAlignment() {
            return alignment;
        }

        public String getSpace() {
            return space;
        }

        public String getPosition() {
            return position;
        }

        public FontAttributes getFontAttributes() {
            return fontAttributes;
        }
    }

    class Title {
        private String alignment;
        private String tapPosition;
        private String position;
        private FontAttributes fontAttributes;

        public String getAlignment() {
            return alignment;
        }

        public String getTapPosition() {
            return tapPosition;
        }

        public String getPosition() {
            return position;
        }

        public FontAttributes getFontAttributes() {
            return fontAttributes;
        }
    }

    class DisplayName {
//        private String space;
//        private String position;
        private FontAttributes fontAttributes;

//        public String getSpace() {
//            return space;
//        }
//
//        public String getPosition() {
//            return position;
//        }

        public FontAttributes getFontAttributes() {
            return fontAttributes;
        }
    }

    class FontAttributes {
        private String font_size;
        private String font_family;
        private boolean bold;
        private boolean italic;

        public String getFont_size() {
            return font_size;
        }

        public String getFont_family() {
            return font_family;
        }

        public boolean isBold() {
            return bold;
        }

        public boolean isItalic() {
            return italic;
        }
    }
}