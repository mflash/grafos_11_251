from graph import Graph

class DepthFirstSearch:
    def __init__(self, g, s):
        self.s = s
        self.marked = {}
        self.__dfs(g, s)

    def __dfs(self, g, s):
        print(f"Entrando: {s}")

if __name__ == "__main__":

    g = Graph("exemplos/tinyG.txt")

    dfs = DepthFirstSearch(g, "0")

    """
    for v in g.getVerts():
        print(f"{v}: ", end="")
        if dfs.hasPathTo(v):
            for w in dfs.pathTo(v):
                print(f"{w} ", end="")
        print()
    print()
    """
