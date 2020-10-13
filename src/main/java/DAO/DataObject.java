package DAO;

public class DataObject {
    private String content;
    private String creator;
    public DataObject(String content, String creator)
    {
        this.content = content;
        this.creator = creator;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public void setmetadata(String metadata)
    {
        this.creator = metadata;
    }
    public String getCreator()
    {
        return creator;
    }
    public String getContent()
    {
        return content;
    }
}
