package Model.Dao;

public class Cocktail {

    private String name;
    private String img;
    private String id;
    private String category = "Category";

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) { this.category = category;}

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

}


