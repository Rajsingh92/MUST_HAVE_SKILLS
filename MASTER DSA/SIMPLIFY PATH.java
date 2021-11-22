
/**
Simplify Path |  Medium | Adobe, Amazon, Facebook, Microsoft |

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a 
Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers 
to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single 
slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory 
names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or 
directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
 */

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return path;
        }

        String result = "";

        String[] array = path.split("/");
        Stack<String> sk = new Stack<>();

        int i = 0;
        while (i < array.length) {

            if (array[i].equals("..")) {
                if (!sk.isEmpty()) {
                    sk.pop();
                }
            } else if (!array[i].equals(".") && !array[i].equals("")) {
                sk.push(array[i]);
            }

            i++;
        }

        if (sk.isEmpty())
            return "/";

        while (!sk.isEmpty()) {
            result = "/" + sk.pop() + result;
        }

        return result;
    }
}