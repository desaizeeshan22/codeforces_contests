package VK_2016;

import javax.print.attribute.standard.PrinterLocation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problemC {
  public static Map<Integer, List<Integer>> adjList;
  public static Map<Integer, List<Integer>> res;
  public static Map<Map.Entry<Integer, Integer>, Integer> roads;

  public static void addEdge(int u, int v) {
    adjList.computeIfAbsent(u, x -> new ArrayList<>());
    adjList.computeIfAbsent(v, x -> new ArrayList<>());
    adjList.get(u).add(v);
    adjList.get(v).add(u);
  }

  public static void dfs(int v, int p, int k) {
    int cnt = 1;
    for (int i = 0; i < adjList.get(v).size(); i++) {
      if (adjList.get(v).get(i) == p) {
        continue;
      }
      if (cnt == k) {
        cnt++;
      }
      List<Integer> value = res.getOrDefault(cnt, new ArrayList<>());
      value.add(getRoad(v, adjList.get(v).get(i)));
      res.put(cnt, value);
      dfs(adjList.get(v).get(i), v, cnt);
      cnt++;
    }
  }

  public static int getRoad(int u, int v) {
    for (Map.Entry<Integer, Integer> entry : roads.keySet()) {
      if ((entry.getKey() == u && entry.getValue() == v) || (entry.getKey() == v && entry.getValue() == u)) {
        return roads.get(entry);
      }
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    adjList = new HashMap<>();
    roads = new HashMap<>();

    int start = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    res = new HashMap<>();

    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      addEdge(u, v);
      if (adjList.get(u).size() > adjList.getOrDefault(start, new ArrayList<>()).size()) {
        start = u;
      }
      if (adjList.get(v).size() > adjList.getOrDefault(start, new ArrayList<>()).size()) {
        start = v;
      }
      Map.Entry<Integer, Integer> ent = Map.entry(u, v);
      roads.put(ent, i);
    }

    dfs(start, -1, -1);
    int k = adjList.get(start).size();
    System.out.println(k);
    for (int i = 1; i <= k; i++) {
      System.out.print(res.getOrDefault(i, new ArrayList<>()).size() + " ");
      for (int j = 0; j < res.getOrDefault(i, new ArrayList<>()).size(); j++) {
        System.out.print(res.get(i).get(j) + " ");
      }
      System.out.println(" ");
    }
  }
}
