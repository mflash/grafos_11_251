#!/usr/bin/python3
#
# Min heap indexada: permite reduzir a prioridade de um item
#

class IndexMinHeap:

    def __init__(self, *args):
        self.heap = [ ' ' ]
        self.dic = {}
        if len(args) > 0:
            self.heap += args[0]

    def add(self, x):
        self.heap.append(x)
        self.dic[x[0]] = len(self.heap)-1
        self.swim(len(self.heap)-1)

    def contains(self, k):
        return k in self.dic

    def isEmpty(self):
        return len(self.heap) == 1

    def swim(self, k):
        while k > 1 and self.heap[k//2][1] > self.heap[k][1]:
            #print("swap",self.heap[k],"and",self.heap[k//2])
            self.__exch(k, k//2)
            k = k // 2

    def sink(self, k, N):
      while 2*k <= N:
        j = 2*k
        if j < N and self.heap[j][1] > self.heap[j+1][1]:
          j += 1
        if self.heap[k][1] <= self.heap[j][1]:
          break
        #print("swap",self.heap[k],"and",self.heap[j])
        self.__exch(k, j)
        k = j

    def __exch(self, k,j):
        self.heap[k], self.heap[j] = self.heap[j], self.heap[k]
        key1 = self.heap[k][0]
        key2 = self.heap[j][0]
        self.dic[key1] = k
        self.dic[key2] = j

    def delMin(self):
        res = self.heap[1]
        #print("move",self.heap[len(self.heap)-1],"to top")
        self.heap[1] = self.heap[len(self.heap)-1]
        self.heap.pop()
        self.sink(1, len(self.heap)-1)
        del self.dic[res[0]]
        return res

    def decreaseValue(self, k, v):
        pos = self.dic[k]
        self.heap[pos][1] = v
        self.swim(pos)

    def printh(self, sp=40):
        b = 1
        elem = 1
        print(self.heap[1:])
        while True:
            print(" "*(sp//2),end="")
            for i in range(b,b+elem):
                if i == len(self.heap):
                    print()
                    return
                print(self.heap[i]," "*(sp-1),end="")
            print()
            b += elem
            elem *= 2
            sp //= 2

    def getData(self): # retorna o conteúdo do heap como uma lista - exceto a posição 0
        return self.heap[1:]

if __name__ == "__main__":

    myheap = IndexMinHeap()
    myheap.add(["A", 5])
    myheap.add(["B", 3])
    myheap.add(["C", 8])
    myheap.add(["D", 1])
    myheap.printh()

    print()
    print("Alterando prioridades:")
    myheap.decreaseValue("B", -1)
    myheap.decreaseValue("C", 2)

    print()
    myheap.printh()
    print()

    print("Retirando por ordem de prioridade:")
    print()
    while not myheap.isEmpty():
        el = myheap.delMin()
        print(el)
  

