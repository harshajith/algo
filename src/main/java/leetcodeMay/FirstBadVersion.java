package leetcodeMay;

/**
 *  First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {

    int badVersion = Integer.MAX_VALUE;
    public int firstBadVersion(int n) {
        badVersion(n, 1, n);
        return badVersion;
    }

    public void badVersion(int n, int left, int right){
        if(left > right) return;

        int mid = left + (right - left)/2;

        if(isBadVersion(mid)){
            badVersion = Math.min(badVersion, mid);
            badVersion(n, left, mid-1);
        }else {
            badVersion(n, mid+1, right);
        }
    }

    private boolean isBadVersion(int mid) {
        if(mid >= 10) return true;
        return false;
    }

    public static void main(String[] args){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(10));
    }

}
