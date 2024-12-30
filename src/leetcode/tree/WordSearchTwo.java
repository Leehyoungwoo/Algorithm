package leetcode.tree;

import java.util.*;

public class WordSearchTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new char[][] {
                        {'a'}
                },
                new String[] { "a" }));
    }

    static class Solution {

        private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private Trie trie = new Trie();
        private Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            // 주어진 단어들을 트라이에 추가
            for (String word : words) {
                trie.addWord(word);
            }

            // 보드의 각 칸에서 DFS로 탐색
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    find(board, i, j, new boolean[board.length][board[i].length], trie.root, "");
                }
            }

            return new ArrayList<>(res);
        }

        private void find(char[][] board, int r, int c, boolean[][] visited, Node node, String word) {
            // 범위 밖이거나 이미 방문한 곳이라면 종료
            if (!isInRange(r, c, visited)) {
                return;
            }

            char ch = board[r][c];
            if (!node.children.containsKey(ch)) {
                return;
            }

            // 현재 문자로 노드를 이동
            node = node.children.get(ch);
            word += ch;

            // 끝 단어를 찾았다면 결과에 추가
            if (node.endOfWord) {
                res.add(word);
                // 중복 추가 방지를 위해 endOfWord를 false로 설정
                node.endOfWord = false;
            }

            // 방문 처리
            visited[r][c] = true;

            // 상하좌우 탐색
            for (int[] dir : direction) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                find(board, nextR, nextC, visited, node, word);
            }

            // 백트래킹: 방문한 상태를 복원
            visited[r][c] = false;
        }

        private boolean isInRange(int r, int c, boolean[][] visited) {
            return r >= 0 && r < visited.length && c >= 0 && c < visited[0].length && !visited[r][c];
        }
    }

    static class Trie {
        Node root = new Node();

        // 단어를 트라이에 추가
        public void addWord(String word) {
            Node node = this.root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
            }
            node.endOfWord = true;
        }
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord;

        public Node() {
        }
    }
}
