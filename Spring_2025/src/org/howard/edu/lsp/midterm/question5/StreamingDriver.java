package org.howard.edu.lsp.midterm.question5;

//A driver class to demonstrate the functionalities of the various media.
 
public class StreamingDriver {
    public static void main(String[] args) {
        // Create instances of the different media
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movies("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land by Barack Obama");

        // Test the common behaviors for all media types (play, pause, stop)
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviors for each media type
        Movies movieWithRewind = (Movies) movie;  
        movieWithRewind.rewind(30);
        System.out.println();

        Audiobook audiobookWithSpeed = (Audiobook) audiobook; 
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        Music musicWithPlaylist = (Music) music;  
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}