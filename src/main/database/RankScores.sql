178. Rank Scores

Table: Scores

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| score       | decimal |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table contains the score of a game. Score is a floating point value with two decimal places.



Write a solution to find the rank of the scores. The ranking should be calculated according to the following rules:

    The scores should be ranked from the highest to the lowest.
    If there is a tie between two scores, both should have the same ranking.
    After a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no holes between ranks.

Return the result table ordered by score in descending order.

The result format is in the following example.

Example 1:

Input:
Scores table:
+----+-------+
| id | score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
Output:
+-------+------+
| score | rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

-- SOLUTION
-- DENSE_RANK() is a window function in postgres
Understanding DENSE_RANK()

  The DENSE_RANK() function calculates the rank of a row in an ordered set of rows.

      Tie Handling: If two or more rows have the same value (a tie), they are assigned the same rank number.

      Gap Handling: Crucially, the rank number for the following row is the next consecutive integer, regardless of the number of tied rows. This prevents any "holes" or gaps in the ranking sequence.


SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) as rank
FROM Scores
ORDER BY score DESC