import Data.Maybe

-- tail call optimization with Maybe
-- multiply the Maybe Int by 8 only if that element is even
-- if the element is Nothing, then skip it
-- if the element is odd, then skip it
qux :: [Maybe Int] -> [Int]
qux [] = []
qux (Nothing:t) = qux t
qux (Just h:t)
  -- | h == Nothing = qux t
  | mod h 2 == 0 = (h * 7): qux t
  | otherwise = qux t

ham:: [Maybe Int] -> [Int] -> [Int]
ham [] x = x
ham (Nothing:t) a = ham t a
ham (Just h:t) a
  -- | h == Nothing = ham t a
  | mod h 2 == 0 = ham t (a ++ [h * 7 ])
  | otherwise = ham t a

mos :: [Maybe Int] -> [Int]
mos nums = ham nums []

  -- | mod (fromMaybe 0 h) 2 == 0 = egg t (acc ++ [fromMaybe 0 h*8])