import java.io.*;
import java.util.*;

class Guvi {
  private static InputReader in;
  private static PrintWriter out;
  public static int N,M;
  public static int[][] grid;
  public static boolean[][] vis;

  public static void main(String[] args) throws IOException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out, true);
    N = in.nextInt();
    M = in.nextInt();
    grid = new int[N][M];
    for (int i = 0; i < N; i++) for (int j = 0; j < M; j++)
      grid[i][j] = in.nextInt();
    
    int max = 0;
    vis = new boolean[N][M];
    for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
      if (vis[i][j] || grid[i][j] == 0) continue;
      max = Math.max(max, dfs(i,j));
    }
    out.println(max);
    out.close();
    System.exit(0);
  }
  
  public static int dfs(int i, int j) {
    if (i < 0 || j < 0 || i >= N || j >= M || vis[i][j] || grid[i][j] == 0) return 0;
    int c = 1;
    vis[i][j] = true;
    c += dfs(i+1,j);
    c += dfs(i,j+1);
    c += dfs(i-1,j);
    c += dfs(i,j-1);
    c += dfs(i+1,j+1);
    c += dfs(i+1,j-1);
    c += dfs(i-1,j+1);
    c += dfs(i-1,j-1);
    return c;
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }


}
