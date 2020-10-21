Jukebox


Winamp


MusicCatalog
-------------
the list of songs/albums that the player supports



gaana -- over 2 million songs

saavn --

spotify --

Apple music -

Amazon Prime Music - 


Task-1
---------
Design a class called MusicItem

MusicItem --> Album/Single

Artist
Genre
YearOfRelease
Album --> No. of songs --> in case of single, it will be 1
total playing time

MusicCatalog class will contain multiple MusicItems


Album, Creedence Clearwater Revival, Cosmo’s Factory, Rock, 1970, 10, 00:36:00
Album, Dire Straits, Brothers in Arms, Rock, 1985, 9, 00:55:00
Single, Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55
Single, Taylor Swift, Shake It Off, Pop, 2014, 1, 00:03:39
Album, Taylor Swift, Reputation, Pop, 2017, 31, 01:24:00
Album, The Complete Greatest Hits, America, Pop/Rock, 2001, 18, 00:59:00


MultiLevel Sorting
--------------------
Artist(ascending order--alphabetically) -----> Year of release(ascending)


while(current!=null && current.data<item) {
	previous = current;
	current = current.next;
}
// insert based on the situation




while(current!=null && isInAscendingOrder(MusicItem musicItem)) {
	previous = current;
	current = current.next;
}
// insert based on the situation










Dire Straits, 1985
The Complete Greatest Hits, 2001
Creedence Clearwater Revival, 1970
Taylor Swift, 2014
Taylor Swift, 2008
Taylor Swift, 2017





Creedence Clearwater Revival, 1970
Dire Straits, 1985
Taylor Swift, 2008
Taylor Swift, 2014
Taylor Swift, 2017
The Complete Greatest Hits, 2001



Task-3
--------
MusicItem
---------
void showDetails();


MusicCatalog
-------------
void showMusicCatalog(Direction direction);





Album, Creedence Clearwater Revival, Cosmo’s Factory, Rock, 1970, 10, 00:36:00
Album, Dire Straits, Brothers in Arms, Rock, 1985, 9, 00:55:00
Album, Louis Armstrong, The Very Best of Louis Armstrong, Jazz, 1998, 40, 02:16:00
Album, Michael Jackson, Thriller, Pop, 1982, 9, 00:42:00
Album, Spice Girls, Spice World, Pop, 1997, 10, 00:38:00
Single, Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55
Single, Taylor Swift, Shake It Off, Pop, 2014, 1, 00:03:39
Album, Taylor Swift, Reputation, Pop, 2017, 31, 01:24:00
Album, The Complete Greatest Hits, America, Pop/Rock, 2001, 18, 00:59:00



filter
---------
by Artist --> Taylor Swift

Single, Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55
Single, Taylor Swift, Shake It Off, Pop, 2014, 1, 00:03:39
Album, Taylor Swift, Reputation, Pop, 2017, 31, 01:24:00


by Artist --> Dire Straits

Album, Dire Straits, Brothers in Arms, Rock, 1985, 9, 00:55:00


by Genre --> Rock

Album, Creedence Clearwater Revival, Cosmo’s Factory, Rock, 1970, 10, 00:36:00
Album, Dire Straits, Brothers in Arms, Rock, 1985, 9, 00:55:00


by Genre --> Pop

Album, Michael Jackson, Thriller, Pop, 1982, 9, 00:42:00
Album, Spice Girls, Spice World, Pop, 1997, 10, 00:38:00
Single, Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55
Single, Taylor Swift, Shake It Off, Pop, 2014, 1, 00:03:39
Album, Taylor Swift, Reputation, Pop, 2017, 31, 01:24:00


by Music Item Name --> Thriller

Album, Michael Jackson, Thriller, Pop, 1982, 9, 00:42:00


by Music Item Name --> Love Story

Single, Taylor Swift, Love Story, Pop, 2008, 1, 00:03:55