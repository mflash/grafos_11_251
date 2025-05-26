#include <string>
#include <sstream>

#ifndef EWGRAPH_EDGE_H
#define EWGRAPH_EDGE_H

struct Edge
{
  std::string v;
  std::string w;
  std::string color;
  float weight;

  Edge() {
    this->v = "";
    this->w = "";
    this->weight = 0.0;
    this->color = "";
  }

  Edge(std::string v, std::string w, float weight) {
    this->v = v;
    this->w = w;
    this->weight = weight;
    this->color = "";
  }

  friend std::ostream& operator<<(std::ostream& os, const Edge& obj) {
    return os << obj.v << "-" << obj.w << " (" << obj.weight << ")";
  }

  friend bool operator<(const Edge& esta, const Edge& outra) {
    return esta.weight < outra.weight;
  }

  friend bool operator<=(const Edge& esta, const Edge& outra) {
    return esta.weight <= outra.weight;
  }

  friend bool operator>(const Edge& esta, const Edge& outra) {
    return esta.weight > outra.weight;
  }
  
  friend bool operator>=(const Edge& esta, const Edge& outra) {
    return esta.weight >= outra.weight;
  }
};

#endif

