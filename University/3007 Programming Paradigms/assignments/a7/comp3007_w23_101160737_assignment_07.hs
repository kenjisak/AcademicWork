import Data.Maybe

longdiv :: Int -> Int -> (Int, Int)
longdiv x 0 = error "cant divide by zero"
longdiv x y
  | x < y = (0, x)
  | otherwise = (fst (longdiv (x-y) y) + 1, snd (longdiv (x-y) y))


longdiv2 :: Int -> Int -> (Maybe Int, Maybe Int)
longdiv2 x 0 = (Nothing, Nothing)
longdiv2 x y
  | x < y = (Nothing, Just x)
  | otherwise = (Just (mymaybefst (longdiv2 (x-y) y) + 1), snd (longdiv2 (x-y) y)) 

mymaybefst:: (Maybe Int, Maybe Int) -> Int -- helper function to get the first value of a tuple of maybes as an int
mymaybefst (Nothing, Nothing) = 0
mymaybefst (Just x, Nothing) = x
mymaybefst (Nothing, Just x) = x
mymaybefst (Just x, Just y) = x

longdiv3:: Int -> Int -> Int -> (Int,Int)
longdiv3 x 0 acc = error "cant divide by zero"
longdiv3 x y acc
  | x < y = (acc, x)  -- if x is less than y, then we cant divide, so we return the acc and x
  | otherwise = longdiv3 (x-y) y (acc+1) -- else division is possible, so we do it and increment the acc

tailoptstart:: Int -> Int -> (Int, Int)
tailoptstart x y = longdiv3 x y 0 -- tail optimized init recursion with acc at 0