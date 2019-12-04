val Array(from, to) = "356261-846303".split('-')
from
to
val inp@Array(t1, t2, t3, t4, t5, t6) = "111111,223450,123789,112233,123444,111122".split(',')
def checkPairs(i: Iterable[Char]) = i.groupBy(identity).map(g => g._2.size).exists(_ >= 2)
def checkPair(i: Iterable[Char]) = i.groupBy(identity).map(g => g._2.size).exists(_ == 2)
t6.toCharArray.groupBy(identity).map(g => g._2.size).exists(_ >= 2)
t6.toCharArray.groupBy(identity).map(g => g._2.size).exists(_ == 2)
val ca1 = t6.toVector
val ca2 = ca1.tail
val cap = ca1.zip(ca2).forall(_-_ <= 0)
def checkSeq(seq: Iterable[Char]) = seq.zip(seq.tail).forall(_-_ <= 0)
def ch1(seq: Iterable[Char]) = checkPair(seq) && checkSeq(seq)
inp.map(seq => ch1(seq.toVector))
def ch2(seq: Iterable[Char]) = checkPairs(seq) && checkSeq(seq)
inp.map(seq => ch2(seq.toVector))