CPPFLAGS = -Wall -g -std=c++17   # Opções do compilador: todos warnings e debug info

all: appgraph appdigraph appdfs appbfs appucycle appdcycle apptopo appewgraph appufind appkruskal appewdigraph appindexminheap

# classe Graph
appgraph = appgraph
appgraph_src = appgraph.cpp graph.cpp
appgraph_obj = $(appgraph_src:.cpp=.o)

# classe Digraph
appdgraph = appdigraph
appdgraph_src = appdigraph.cpp digraph.cpp graph.cpp
appdgraph_obj = $(appdgraph_src:.cpp=.o)

# DFS
appdfs = appdfs
appdfs_src = appdfs.cpp graph.cpp dfs.cpp
appdfs_obj = $(appdfs_src:.cpp=.o)

# BFS
appbfs = appbfs
appbfs_src = appbfs.cpp graph.cpp bfs.cpp
appbfs_obj = $(appbfs_src:.cpp=.o)

# Ciclos nao dirigidos
appucycle = appucycle
appucycle_src = appundirectedcycle.cpp undirectedcycle.cpp graph.cpp
appucycle_obj = $(appucycle_src:.cpp=.o)

# Ciclos dirigidos
appdcycle = appdcycle
appdcycle_src = appdirectedcycle.cpp directedcycle.cpp digraph.cpp graph.cpp
appdcycle_obj = $(appdcycle_src:.cpp=.o)

# Ord. Topológica
apptopo = apptopo
apptopo_src = apptopo.cpp graph.cpp digraph.cpp topological.cpp
apptopo_obj = $(apptopo_src:.cpp=.o)

# Ord. Topológica - aplicação matriz CC
apptopocc = apptopocc
apptopocc_src = apptopocc.cpp graph.cpp digraph.cpp topological.cpp
apptopocc_obj = $(apptopocc_src:.cpp=.o)

# classe UnionFind
appufind = appufind
appufind_src = appunionfind.cpp unionfind.cpp edgeweightedgraph.cpp
appufind_obj = $(appufind_src:.cpp=.o)

# classe EdgeWeightedGraph
appewgraph = appewgraph
appewgraph_src = appewgraph.cpp edgeweightedgraph.cpp
appewgraph_obj = $(appewgraph_src:.cpp=.o)

# classe KruskalMST
appkruskal = appkruskal
appkruskal_src = kruskalmst.cpp edgeweightedgraph.cpp appkruskal.cpp unionfind.cpp
appkruskal_obj = $(appkruskal_src:.cpp=.o)

# classe EdgeWeightedDigraph
appewdigraph = appewdigraph
appewdigraph_src = appewdigraph.cpp edgeweighteddigraph.cpp edgeweightedgraph.cpp
appewdigraph_obj = $(appewdigraph_src:.cpp=.o)

# classe IndexMinHeap
appindexminheap = appindexminheap
appindexminheap_src = appindexminheap.cpp
appindexminheap_obj = $(appindexminheap_src:.cpp=.o)

$(appgraph): $(appgraph_obj)
	g++ $(CPPFLAGS) $(appgraph_obj) -o $@

$(appdgraph): $(appdgraph_obj)
	g++ $(CPPFLAGS) $(appdgraph_obj) -o $@

$(appdfs): $(appdfs_obj)
	g++ $(CPPFLAGS) $(appdfs_obj) -o $@

$(appbfs): $(appbfs_obj)
	g++ $(CPPFLAGS) $(appbfs_obj) -o $@

$(appucycle): $(appucycle_obj)
	g++ $(CPPFLAGS) $(appucycle_obj) -o $@

$(appdcycle): $(appdcycle_obj)
	g++ $(CPPFLAGS) $(appdcycle_obj) -o $@

$(apptopo): $(apptopo_obj)
	g++ $(CPPFLAGS) $(apptopo_obj) -o $@

$(apptopocc): $(apptopocc_obj)
	g++ $(CPPFLAGS) $(apptopocc_obj) -o $@

$(appewgraph): $(appewgraph_obj)
	g++ $(CPPFLAGS) $(appewgraph_obj) -o $@

$(appufind): $(appufind_obj)
	g++ $(CPPFLAGS) $(appufind_obj) -o $@

$(appkruskal): $(appkruskal_obj)
	g++ $(CPPFLAGS) $(appkruskal_obj) -o $@

$(appewdigraph): $(appewdigraph_obj)
	g++ $(CPPFLAGS) $(appewdigraph_obj) -o $@

$(appindexminheap): $(appindexminheap_obj)
	g++ $(CPPFLAGS) $(appindexminheap_obj) -o $@
clean:
	-@ rm -f $(appgraph_obj) $(appgraph) $(appdgraph_obj) $(appdgraph) $(appdfs_obj) $(appdfs) \
		 $(appbfs_obj) $(appbfs) $(appucycle) $(appucycle_obj) $(appdcycle) $(appdcycle_obj) \
		 $(apptopo_obj) $(apptopo) \
		 $(apptopocc_obj) $(apptopo_cc) \
		 $(appewgraph_obj) $(appewgraph) \
		 $(appufind) $(appufind_obj) \
		 $(appkruskal) $(appkruskal_obj) \
		 $(appewdigraph) $(appewdigraph_obj)

	   	
