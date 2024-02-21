package movie;

public class Movie {
    private class MovieInfo {
        private int duration;
        private String genre;
        private String[] directors;

        public MovieInfo(int duration, String genre, String[] directors) {
            this.duration = duration;
            this.genre = genre;
            this.directors = directors;
        }

        public int getDuration() {
            return duration;
        }

        public String getGenre() {
            return genre;
        }

        public String[] getDirectors() {
            return directors;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Duration: ").append(duration).append(" minutes\n");
            sb.append("Genre: ").append(genre).append("\n");
            sb.append("Directors: ");
            for (int i = 0; i < directors.length; i++) {
                sb.append(directors[i]);
                if (i < directors.length - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Movie movie = new Movie();

        String[] directors = {"Director 1", "Director 2", "Director 3"};
        Movie.MovieInfo info = movie.new MovieInfo(120, "Action", directors);

        System.out.println(info);
    }
}
