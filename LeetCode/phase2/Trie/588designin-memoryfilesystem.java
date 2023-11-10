import java.util.Arrays;

class FileSystem {

    TrieNode root = new TrieNode();

    public List<String> ls(String path) {
        TrieNode curNode = root;

        if (!path.equals('/')) {
            String[] list = path.split("/");
            String curString;
            for (int i = 1; i < list.length; i++) {
                curString = list[i];
                curNode = curNode.children.get(curString);

                //Check if this is a file, not a directory
                if (i == list.length - 1 && curNode.content != null) {
                    return Arrays.asList(curString);
                }
            }

            //If it is a directory return list of files and directories
            List<String> children = new LinkedList<>(curNode.children.keySet());
            return children;
        }
    }

    //Making a new directory
    public void mkdir(String path) {
        TrieNode curNode = root;
        String[] list = path.split("/");
        String curString;

        for (int i = 1; i < list.length; i++) {
            curString = list[i];
            //if the directory does not exists, create it
            if (!curNode.children.containsKey(curString)) {
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }
    }

    public void addContentToFile(String filepath, String content) {

        TrieNode curNode = root;
        String[] list = filepath.split("/");
        String curString;

        for (int i = 1; i < list.length; i++) {
            curString = list[i];
            if (!curNode.children.containsKey(curString)) {
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }
        // Chech the content
        if (curNode.content != null) {
            curNode.content += content;
            } else {
            curNode.content = content;
        }
    }

    public String readContentForFile(String filePath) {

        TrieNode curNode = root;
        String[] list = filePath.split("/");
        String cuString;
        for (int i = 1; i < list.length; i++) {
            cuString = list[i];

            //If path does not exist,create it
            if (!curNode.children.containsKey(curString)) {
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(cuString);
        }

        // wreturn the content, be it null or String
        return curNode.content;


    }

}

class TrieNode {
    String content = null;
    Map<String, TrieNode> children = new TreeMap<>();
}

/*
 * Problem:
 * > Design a file-system that simulates in-memory file system
 * FileSystem() Initializes the object of the system
 * 
 * > List<String> Ls(String path)
 *  - If path is a file path, returns a list that only contains this file's name
 *  - if path is a directory path, returns a list of file and directory names in this directory
 * The answer hsould be in lexicographic order.
 * 
 * > void mkdir(String path) makes a new directory according to the given path. The given directory path does not
 * exist if the middle directories in the path do not exist, you should create them as well.
 * 
 * > void addContentToFile(String filepath, string content)
 *  -If "filePath" does not exist, creates that file containing given "content".
 *  -If "filePath" already exists, appends the given "content" to original content.
 * 
 * > String readContentForFile(Sring filePath) returns the content in the file at "filePaath"
 * 
 * Constraints:
 * 
 * - 1 <= path.length, filePath.length <= 100
 * - "path" and "filePath" are absolute paths whihc begin with '/'
 * and do not end with '/' except that path is just '/'
 * - You can assume that all directory names and file names only contain lowercase letters, and the same names 
 * will ot exist in the same directory
 * -You can assume that all operations will be passed valid parameters, and users will not attempt to retriev file content
 * or list a directory or file that does not exist.
 * 1 <= content.length <= 50
 * At most '300' calls will be made to 'ls'. 'mkdir', 'addContentToFile', and 'readContentFromFile'.
 * 
 * 
 * 
 * -TrieMap (not part of the standard Java collections):
        >A Trie, also called a prefix tree or radix tree, is a specialized tree-like
        data structure that is used to store associative data structures.
        >More memory efficient when dealing with strings or collections of strings.
        >The time complexity for searching, inserting, and deleting is 
        O(length of the word).
        >The keys are usually strings, with the trie structure speeding up the 
        retrieval of keys with the same prefix.
 */