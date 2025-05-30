#ifndef _MINHEAP_H
#define _MINHEAP_H

#include <ctime>
#include <iomanip>
#include <iostream>
#include <stdexcept>
#include <vector>
#include <map>

template <typename V>
class ValuePos {
public:
    V value;
    int pos;

    ValuePos(V v, int p) {
        this->value = v;
        this->pos =p;
    }

    ValuePos() {}
};

template <typename T, typename V>
class Tuple {
public:
    T key;
    V value;
    Tuple(T key, V value) {
        this->key = key;
        this->value = value;
    }

    Tuple() {
    }

    friend std::ostream& operator<<(std::ostream& os, const Tuple& t) {
        os << "(" << t.key << ", " << t.value << ")";
        return os;
    }
};

template <typename T, typename V>
class IndexMinHeap {
private:
    std::vector<Tuple<T,V>> heap;
    std::map<T,ValuePos<V>> dic;

    void swim(int k) {
        while (k > 1 && heap[k / 2].value > heap[k].value) {
            //std::cout << "Swap " << heap[k] << " with " << heap[k / 2] << std::endl;
            int j = k / 2;
            dic[heap[k].key] = ValuePos(heap[j].value, j);
            dic[heap[j].key] = ValuePos(heap[k].value, k);
            std::swap(heap[k], heap[k / 2]);
            k = k / 2;
        }
    }

    void sink(int k, int size) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j].value > heap[j + 1].value) j++;
            if (heap[k].value <= heap[j].value) break;
            dic[heap[k].key] = ValuePos(heap[j].value, j);
            dic[heap[j].key] = ValuePos(heap[k].value, k);
            std::swap(heap[k], heap[j]);
            k = j;
        }
    }

public:
    IndexMinHeap() {
        heap.push_back(Tuple<T,V>());  // Placeholder for index 0
    }

    bool isEmpty() const {
        return heap.size() <= 1;
    }

    void put(T key, V data) {
        heap.push_back(Tuple(key,data));
        dic[key] = ValuePos(data, heap.size()-1);
        swim(heap.size() - 1);
    }

    int size() {
        return heap.size()-1;
    }

    T delMin() {
        if (heap.size() <= 1) throw std::out_of_range("Heap is empty");
        Tuple<T,V> res = heap[1];
        heap[1] = heap.back();
        heap.pop_back();
        dic.erase(heap[1].key);
        sink(1, heap.size()-1);
        return res.key;
    }

    void decreaseValue(T key, V value) {
        //if (!contains(k)) throw new NoSuchElementException("Chave não existe");
        ValuePos vp = dic[key];
        vp.value = value;
        heap[vp.pos].value = value;
        swim(vp.pos);
    }

    void print() const {
        int size = heap.size() - 1;
        int b = 1;
        int elem = 1;
        int sp = 32;

       // for (int j = 1; j <= size; j++)
       //     std::cout << heap[j] << " ";
       // std::cout << std::endl;
        for(auto item: dic) {
            ValuePos<V> v = item.second;
            std::cout << item.first << "->" << v.pos << " ";
        }
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
