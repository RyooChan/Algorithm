/**
https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

[HackerRank] repeated-string java 풀이
*/

public static long repeatedString(String s, long n) {
    long aCount = 0;

    for(int i=0; i<s.length(); i++) {
        if(s.charAt(i) == 'a') aCount++;
    }

    long multiple = n / s.length();
    aCount *= multiple;

    long plus = n % s.length();
    for(int i=0; i<plus; i++) {
        if(s.charAt(i) == 'a') aCount++;
    }

    return aCount;
}
