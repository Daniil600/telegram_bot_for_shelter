package skypro.teamwork.telegram_bot_for_shelter.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "app_document")
public class AppDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telegramFileId;
    private String docName;
    @OneToOne
    private BinaryContent binaryContent;
    private String mimeType;
    private Long fileSize;

    public AppDocument() {
    }




    public static AppDocumentBuilder builder() {
        return new AppDocumentBuilder();
    }

    public Long getId() {
        return id;
    }

    public String getTelegramFileId() {
        return telegramFileId;
    }

    public void setTelegramFileId(String telegramFileId) {
        this.telegramFileId = telegramFileId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public BinaryContent getBinaryContent() {
        return binaryContent;
    }

    public void setBinaryContent(BinaryContent binaryContent) {
        this.binaryContent = binaryContent;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public static class AppDocumentBuilder {
        private AppDocument appDocument;

        public AppDocumentBuilder() {
            appDocument = new AppDocument();
        }

        public AppDocumentBuilder telegramFileId(String telegramFileId) {
            appDocument.setTelegramFileId(telegramFileId);
            return this;
        }

        public AppDocumentBuilder docName(String docName) {
            appDocument.setDocName(docName);
            return this;
        }

        public AppDocumentBuilder binaryContent(BinaryContent binaryContent) {
            appDocument.setBinaryContent(binaryContent);
            return this;
        }

        public AppDocumentBuilder mimeType(String mimeType) {
            appDocument.setMimeType(mimeType);
            return this;
        }

        public AppDocumentBuilder fileSize(Long fileSize) {
            appDocument.setFileSize(fileSize);
            return this;
        }

        public AppDocument build() {
            return appDocument;
        }
    }

    public AppDocument(Long id, String telegramFileId, String docName, BinaryContent binaryContent, String mimeType, Long fileSize) {
        this.id = id;
        this.telegramFileId = telegramFileId;
        this.docName = docName;
        this.binaryContent = binaryContent;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppDocument that = (AppDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(telegramFileId, that.telegramFileId) && Objects.equals(docName, that.docName) && Objects.equals(binaryContent, that.binaryContent) && Objects.equals(mimeType, that.mimeType) && Objects.equals(fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telegramFileId, docName, binaryContent, mimeType, fileSize);
    }

    @Override
    public String toString() {
        return "AppDocument{" +
                "id=" + id +
                ", telegramFileId='" + telegramFileId + '\'' +
                ", docName='" + docName + '\'' +
                ", binaryContent=" + binaryContent +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }


}

