package com.pluralsight.kinesis.module2;

public class LangAndTime {
    private String language;
    private String publicationTime;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String userName) {
        this.language = userName;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LangAndTime that = (LangAndTime) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        return publicationTime != null ? publicationTime.equals(that.publicationTime) : that.publicationTime == null;
    }

    @Override
    public int hashCode() {
        int result = language != null ? language.hashCode() : 0;
        result = 31 * result + (publicationTime != null ? publicationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LangAndTime{" +
                "language='" + language + '\'' +
                ", publicationTime='" + publicationTime + '\'' +
                '}';
    }
}
