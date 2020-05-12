package leetcode.random;


import java.util.*;

/**
 * FAVORITE GENRES
 * Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs.
 * Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs belonging to this genre.
 * The task is to return a map Map<String, List<String>>, where the key is a username and the value is a list of the user's favorite genres.
 * Favorite genre is a genre with the most song.
 *
 * Example :
 * Input:
 *
 * userMap = {
 *    "David": ["song1", "song2", "song3", "song4", "song8"],
 *    "Emma":  ["song5", "song6", "song7"]
 * },
 * genreMap = {
 *    "Rock":    ["song1", "song3"],
 *    "Dubstep": ["song7"],
 *    "Techno":  ["song2", "song4"],
 *    "Pop":     ["song5", "song6"],
 *    "Jazz":    ["song8", "song9"]
 * }
 * Output:
 * {
 *    "David": ["Rock", "Techno"],
 *    "Emma":  ["Pop"]
 * }
 */
public class FavouriteGenres {

    /**
     *
     * @param userMap
     * @param genreMap
     * @return
     */
    public Map<String, List<String>> favouriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap){

        Map<String, List<String>> favouriteGenres = new HashMap<>();
        HashMap<String, String> songGenreMap = new HashMap<>();
        for(String genre: genreMap.keySet()){
            genreMap.get(genre).stream().forEach(songId -> songGenreMap.put(songId, genre));
        }


        for(String user: userMap.keySet()){
            Map<String, Integer> genreFrequencyMap = new HashMap<>();
            List<String> favouriteGenes = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            List<String> userSongs = userMap.get(user);
            for(String song: userSongs){
                String genre = songGenreMap.get(song); // O(1)
                int newFrequency = genreFrequencyMap.getOrDefault(genre, 0) + 1;
                genreFrequencyMap.put(genre, newFrequency);
            }
            for(String genre: genreFrequencyMap.keySet()){
                int frequency = genreFrequencyMap.get(genre);
                TreeMap<Integer, List<String>> treeMap = new TreeMap<>();

            }
            favouriteGenres.put(user, favouriteGenes);
        }
        return favouriteGenres;
    }
}
