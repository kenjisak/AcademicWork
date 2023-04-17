-- Kenji Isak Laguan 101160737
import Debug.Trace

startfindingdivs :: Int -> [Int] -- starts recursive func to find list of divisors and returns the full list of divisors for an Int given
startfindingdivs num = finddivisors num 1 -- starts the recursion with dividing the num by 1

finddivisors :: Int -> Int -> [Int] -- finds the list of divisors for an Int recursively
-- base case if divisor reaches num given
finddivisors num divisor
    | num == divisor = [1] -- base case if num and divisor are the same, 12 and 12
    | checkmod == 0 = (div num divisor) : finddivisors num (divisor + 1) -- if it divides evenly then its a divisor and concat it and recursive call to increment the divisor
    | otherwise = finddivisors num (divisor + 1) -- we dont include the num since its not divided evenly
    where checkmod = mod num divisor

isprime :: Int -> Bool
isprime 1 = trace "1 is neither a prime or a composite.\nTherefore is this a prime number?" False
isprime num 
    | startfindingdivs num == [num,1] = trace (show num ++ " has a list of divisors of itself and 1: " ++ show (startfindingdivs num) ++ "\nTherefore is this a prime number?") True -- if its just the num itself and 1, then its a prime number
    | otherwise = trace (show num ++ " has a list of divisors that isnt only itself and 1: " ++ show (startfindingdivs num) ++ "\nTherefore is this a prime number?") False -- else has 1 or more than 2 divisors and is not a prime number