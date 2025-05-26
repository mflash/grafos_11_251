#ifndef _MINHEAP_H
#define _MINHEAP_H

#include <ctime>
#include <iomanip>
#include <iostream>
#include <stdexcept>
#include <vector>

template <typename T>
class MinHeap {
 private:
  std::vector<T> heap;

  void swim(int k) {
    while (k > 1 && heap[k / 2] < heap[k]) {
      //std::cout << "Swap " << heap[k] << " with " << heap[k / 2] << std::endl;
      std::swap(heap[k], heap[k / 2]);
      k = k / 2;
    }
  }

  void sink(int k, int size) {
    while (2 * k <= size) {
      int j = 2 * k;
      if (j < size && heap[j] > heap[j + 1]) j++;
      if (heap[k] <= heap[j]) break;
      std::swap(heap[k], heap[j]);
      k = j;
    }
  }

 public:
  MinHeap() {
    heap.push_back(T());  // Placeholder for index 0
  }

  MinHeap(T* arr, int size) {
    heap.push_back(T());  // Placeholder for index 0
    for (int i = 0; i < size; i++) heap.push_back(arr[i]);
  }

  void sort() {
    int n = heap.size() - 1;
    // 1. Transformar o vetor em um heap
    // usando a operação sink

    for (int pos = n / 2; pos >= 1; pos--) {
      sink(pos, n);
    }

    // 2. Ordenar o vetor usando novamente
    // a operação de sink

    while (n > 1) {
      std::swap(heap[1], heap[n]);
      n--;
      sink(1, n);
    }
  }

  void put(T data) {
    heap.push_back(data);
    swim(heap.size() - 1);
  }

  T get() {
    if (heap.size() <= 1) throw std::out_of_range("Heap is empty");
    T res = heap[1];
    heap[1] = heap.back();
    heap.pop_back();
    sink(1, heap.size-1);
    return res;
  }

  void print() const {
    int size = heap.size() - 1;
    int b = 1;
    int elem = 1;
    int sp = 32;

    for (int j = 1; j <= size; j++) std::cout << heap[j] << " ";
    std::cout << std::endl;

    while (true) {
      for (int j = 0; j <= sp / 2; j++) std::cout << " ";
      for (int i = b; i < b + elem; i++) {
        if (i > size) {
          std::cout << std::endl;
          return;
        }
        std::cout << heap[i];
        for (int j = 0; j < sp; j++) std::cout << " ";
      }
      std::cout << std::endl;
      b = b + elem;
      elem = 2 * elem;
      sp = sp / 2;
    }
  }

  void printArray() const {
    for (size_t i = 1; i < heap.size(); i++) std::cout << heap[i] << " ";
    std::cout << std::endl;
  }
};
#endif
