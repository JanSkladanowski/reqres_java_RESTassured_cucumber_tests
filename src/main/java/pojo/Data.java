package pojo;

public class Data {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    private Data(DataBuilder builder){
        this.id = builder.id;
        this.email = builder.email;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.avatar = builder.avatar;
    }

    public static class DataBuilder{

        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public DataBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public DataBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public DataBuilder setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public DataBuilder setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public DataBuilder setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Data build(){
            return new Data(this);
        }
    }
}
