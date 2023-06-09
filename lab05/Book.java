public record Book(String title, String author, int pages) {
    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", pages=" + pages +
               '}';
    }
    public String shortDescription() {
        return title + " by " + author;
    }
}