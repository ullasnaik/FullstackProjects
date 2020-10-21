## Problem Statement - MusicPlayer - Playlist & Recently Added Modules

In this challenge, you need to build the playlist creation module and most recently added songs modules of a MusicPlayer.

Design a class called Song that will be used to model entries in your playlist. This class will be used to instantiate objects used for storing information about the Song that is featured in both the lists.

To catalog the music and make it easy to search, there are a couple of attributes that are crucial:


Artist: This can be an individual, for example “Michael Jackson”; Or it can be the name of a group, for example, “The Spice Girls”


Genre: This indicates the type of music the album/single represents, for example “Pop”, or “Rock”, or “Jazz”, or “Rap”, or “Classical”, or “Blues”, or “Country”, etc.


Other attributes that may be useful to include are:

- Year in which the music item was released
- Playing time in hh:mm:ss

So, for example a song entry could be organized as:

Artist, Song Name, Genre, Year of Release, Playing Time

Examples of entries in this format would be:
```
Taylor Swift, Shake It Off, Pop, 2014, 1, 00:03:39
Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55
Taylor Swift, Reputation, Pop, 2017, 31, 01:24:00
Maroon 5, Memories, Pop, 2019, 00:03:09
Imagine Dragons, Believer, Pop/Rock, 00:03:24
Ed Sheeran, Perfect, Pop, 2017, 00:04:23
```
Now design a class called Playlist that can be used to create a queue of the type Song that are in the Playlist.


### Task 1

In case of the playlist, the songs available in the list should be displayed in the same order in which they have been added to the list. If a song is removed from the playlist, it should be the oldest song added to the playlist and any new song should be added at the end of the playlist.

### Task 2

In case of the Most Recently Added List, the songs available in the list should be displayed starting from the latest song which is added to any playlist.

