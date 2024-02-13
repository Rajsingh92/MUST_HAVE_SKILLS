

class Solution:
    def dfs(self,graph,stack,visited,src):
        visited[src] = True

        for nbr in self.graph[src]:
            if visited[nbr] == False:
                self.dfs(graph,stack,visited,nbr)

        stack.append(src)

    def topologicalSort(self,graph):
        stack = []
        visited = [False for _ in range(len(graph))]

        for i in range(len(graph)):
            if visited[graph[i]] == False:
                self.dfs(graph,stack,visited,i)

        print(stack[::-1])
        

