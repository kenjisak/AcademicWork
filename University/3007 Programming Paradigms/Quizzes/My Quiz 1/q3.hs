sel2 :: (Int,Int,String,Int,String,String) -> Int
sel2 (_,second,_,_,_,_) = second

sel4 :: (Int,Int,String,Int,String,String) -> Int
sel4 (_,_,_,fourth,_,_) = fourth

q3 :: [(Int,Int,String,Int,String,String)] -> [Int]
q3 [] = []
q3 (h:t) = sel2 h + sel4 h : q3 t

-------------------------------------------------------------------------------
q33 :: [(Int,Int,String,Int,String,String)] -> [Int]
q33 [] = []
q33 list = (sel2 (head list)) + (sel4 (head list)) : (q33 (tail list))