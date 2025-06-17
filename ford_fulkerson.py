from collections import deque


infinity = float("inf")


def make_graph():
    # identical graph as the YouTube video: https://youtu.be/Tl90tNtKvxs
    return [
            [0, 10, 0, 10, 0, 0],
            [0, 0, 4, 2, 8, 0],
            [0, 0, 0, 0, 0, 10],
            [0, 0, 0, 0, 9, 0],
            [0, 0, 6, 0, 0, 10],
            [0, 0, 0, 0, 0, 0],
        ]


# find paths from source to sink with breadth-first search
def bfs(G, source, sink, parent):
    visited = set()
    queue = deque()
    queue.append(source)
    visited.add(source)
 
    while queue:
        node = queue.popleft()
        for i in range(len(G[node])):
            if i not in visited and G[node][i] > 0:
                queue.append(i)
                visited.add(i)
                parent[i] = node
 
    return sink in visited


def ford_fulkerson(G, source, sink):
    # This array is filled by breadth-first search (bfs) and stores path
    parent = [-1] * (len(G))
    max_flow = 0

    while bfs(G, source, sink, parent):
        path = []
        t = parent[sink]
        path.append(sink)
        while t != -1:
            path.insert(0, t)
            t = parent[t]
        
        print(path)

        path_flow = infinity
        s = sink
 
        while s != source:
            # Find the minimum value in selected path
            path_flow = min(path_flow, G[parent[s]][s])
            s = parent[s]

        print("Fluxo: ", path_flow)
        max_flow += path_flow

        v = sink
 
        # add or subtract flow based on path
        while v != source:
            u = parent[v]
            G[u][v] -= path_flow # adicinando fluxo: subtraindo peso da aresta "que vai"
            G[v][u] += path_flow # retirando  fluxo: adicionando peso na aresta "que volta"
            # print(f"Adicionando fluxo em {u}->{v}")
            # print(f"Retirando   fluxo de {v}->{u}")
            v = parent[v]

    return max_flow


def main():
    G = make_graph()
    source = 0
    sink = 5
    max_flow = ford_fulkerson(G, source, sink)
    print(f'Maximum flow: {max_flow}')

    print()
    print("digraph {")
    print("rankdir=LR")
    for v in range(len(G)):
        for w in range(len(G)):
            if v != w and G[v][w] != 0:
                print(f'{v} -> {w} [label={G[v][w]}]')
    print("}")

if __name__ == "__main__":
    main()

