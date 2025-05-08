from graph import Graph

class DepthFirstSearch:
    def __init__(self, g, s):
        self.s = s
        self.marked = {}
        self.edgeTo = {}
        self.__dfs(g, s)

    def hasPathTo(self, v):
        return False

    def pathTo(self, v):
        path = []
        return path

    def __dfs(self, g, s):
        print(f"Entrando: {s}")
        self.marked[s] = True
        for w in g.getAdj(s):
            if w not in self.marked:
                self.__dfs(g, w)
        print(f"Saindo: {s}")

if __name__ == "__main__":

    g = Graph("exemplos/tinyG.txt")

    dfs = DepthFirstSearch(g, "0")

    for v in g.getVerts():
        print(f"{v}: ", end="")
        if dfs.hasPathTo(v):
            for w in dfs.pathTo(v):
                print(f"{w} ", end="")
        print()
    print()
