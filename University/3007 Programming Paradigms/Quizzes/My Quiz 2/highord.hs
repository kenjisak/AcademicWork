listcompex :: [Int] -> [Int]
listcompex nums = [9^i - 9*i - 9 | i <- nums, (mod i 61) < 52]


firstexp :: [Int] -> [Int]
firstexp [] = []
firstexp (h:t)
  | (mod h 61) < 52 = (9^h - 9*h - 9): firstexp(t)
  | otherwise = firstexp t


predcheck:: Int -> Bool --predicate for filter
predcheck i 
  | (mod i 61) < 52 = True
  | otherwise = False


oper :: Int -> Int --transform for map
oper i = 9^i - 9*i - 9

secondexp :: [Int] -> [Int] -- uses both map and filter
secondexp [] = []
secondexp nums = map (oper) (filter predcheck nums)

-------------------------------------------------- other way
-- ep2filter:: [Int] -> [Int]
-- ep2filter [] = []
-- ep2filter (h:t)
--   | (mod i 61) < 52 = h : ep2filter(t)
--   | otherwise = ep2filter t

-- ep2 :: [Int] -> [Int]
-- ep2 [] = []
-- ep2 nums = map (oper) (ep2filter nums)

