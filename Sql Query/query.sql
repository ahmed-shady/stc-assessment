SELECT U.user_id, U.username, TD.training_id, TD.training_date, count(*)
FROM User U
INNER JOIN Training_details TD
ON U.user_id = TD.user_id
GROUP BY U.user_id, TD.training_id, TD.training_date
having count(*) > 1
ORDER BY TD.training_date;
