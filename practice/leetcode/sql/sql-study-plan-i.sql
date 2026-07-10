-- DAY 1

-- https://leetcode.com/problems/big-countries/submissions/
select name, population, area from World where area >= 3000000 OR population >= 25000000;
select name, population, area from World where area >= 3000000
union
select name, population, area from World where population >= 25000000;

-- https://leetcode.com/problems/recyclable-and-low-fat-products/submissions/
select product_id from Products where low_fats = 'Y' and recyclable = 'Y';

-- https://leetcode.com/problems/find-customer-referee/submissions/
select name from Customer where referee_id != 2 or referee_id is null;

-- https://leetcode.com/problems/customers-who-never-order/submissions/
select Customers.name as 'Customers' from Customers left outer join Orders on Customers.id = Orders.customerId where Orders.id is null;
select Customers.name as 'Customers' from Customers where Customers.id not in (select customerId from Orders);

-- DAY 2

-- https://leetcode.com/problems/calculate-special-bonus/submissions/
select employee_id, case when ((employee_id % 2) != 0 and name not like 'M%') then salary else 0 end as 'bonus' from Employees order by employee_id;

-- https://leetcode.com/problems/swap-salary/submissions/
update Salary set sex = case sex when 'm' then 'f' when 'f' then 'm' else null end;

-- https://leetcode.com/problems/delete-duplicate-emails/submissions/
delete p1 from Person p1, Person p2 where p1.email = p2.email and p1.id > p2.id;
delete p1 from Person p1 join Person p2 where p1.email = p2.email and p1.id > p2.id;
delete from Person where id not in (select * from (select min(id) from Person group by email) as id);

-- DAY 3

-- https://leetcode.com/problems/fix-names-in-a-table/submissions/
select user_id, concat(substr(upper(name), 1, 1), substr(lower(name), 2, length(name))) as 'name' from Users order by user_id;

-- https://leetcode.com/problems/group-sold-products-by-the-date/submissions/
select sell_date, count(distinct(product)) as 'num_sold', group_concat(distinct product order by product) as 'products' from Activities group by sell_date order by sell_date asc;

-- https://leetcode.com/problems/patients-with-a-condition/submissions/
select patient_id, patient_name, conditions from Patients where conditions like 'DIAB1%' or conditions like '% DIAB1%';

-- DAY 4

-- https://leetcode.com/problems/employees-with-missing-information/submissions/
select e.employee_id from Employees e left outer join Salaries s on e.employee_id = s.employee_id where s.salary is null
union 
select s.employee_id from Salaries s left outer join Employees e on e.employee_id = s.employee_id where e.name is null
order by employee_id;

-- https://leetcode.com/problems/rearrange-products-table/submissions/
select product_id, "store1" as store, store1 as price from Products where store1 is not null
union
select product_id, "store2" as store, store2 as price from Products where store2 is not null
union
select product_id, "store3" as store, store3 as price from Products where store3 is not null
order by product_id;

-- https://leetcode.com/problems/tree-node/submissions/
select id, "Root" as type from Tree where p_id is null
union 
select id, "Inner" as type from Tree where id in (select p_id from Tree) and p_id is not null
union
select t1.id as "id", "Leaf" as type from Tree t1 left outer join Tree t2 on t1.id = t2.p_id where t2.p_id is null and t1.p_id is not null
order by id;
select distinct l.id, 
case 
    when l.p_id is null then "Root"
    when l.p_id is not null and r.p_id is null then "Leaf"
    else "Inner"
end as type
from Tree l left outer join Tree r on l.id = r.p_id 
order by l.id;

-- https://leetcode.com/problems/second-highest-salary/
select max(salary) as "SecondHighestSalary" from Employee where salary not in (select max(salary) from Employee);

-- DAY 5

-- https://leetcode.com/problems/combine-two-tables/submissions/
select p.firstName, p.lastName, a.city, a.state from Person p left outer join Address a on p.personId = a.personId where p.firstName is not null; 

-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
select v.customer_id, count(v.visit_id) as 'count_no_trans' from Visits v left outer join Transactions t on v.visit_id = t.visit_id where t.transaction_id is null group by v.customer_id order by 'count_no_trans';

-- https://leetcode.com/problems/article-views-i/
select distinct(v.author_id) as 'id' from Views v where v.author_id = v.viewer_id order by v.author_id asc;

-- DAY 6

-- https://leetcode.com/problems/rising-temperature/
select w.id from Weather w inner join Weather o on datediff(w.recordDate, o.recordDate) = 1 and w.temperature > o.temperature;

-- https://leetcode.com/problems/sales-person/submissions/
select distinct(s.name) from SalesPerson s where s.sales_id not in (select o.sales_id from Orders o where o.com_id in (select c.com_id from Company c where c.name = "RED")) order by s.name;

-- DAY 7

-- https://leetcode.com/problems/user-activity-for-the-past-30-days-i/
select activity_date as 'day', count(distinct user_id) as 'active_users' from Activity group by activity_date having activity_date between date_sub('2019-07-27', interval 29 day) and '2019-07-27' order by activity_date;

-- https://leetcode.com/problems/daily-leads-and-partners/
select date_id, make_name, count(distinct lead_id) as 'unique_leads', count(distinct partner_id) as 'unique_partners' from DailySales group by date_id, make_name;

-- https://leetcode.com/problems/find-followers-count/
select user_id, count(follower_id) as 'followers_count' from Followers f group by user_id order by user_id;

-- DAY 8

-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
select customer_number from Orders group by customer_number order by count(order_number) desc limit 1;

-- https://leetcode.com/problems/game-play-analysis-i/
select player_id, min(event_date) as 'first_login' from Activity group by player_id order by player_id;

-- https://leetcode.com/problems/the-latest-login-in-2020/
select e.user_id, max(e.time_stamp) as 'last_stamp' from (select user_id, time_stamp from Logins where time_stamp between '2020-01-01 00:00:00' and '2020-12-31 23:59:59') e group by e.user_id;

-- https://leetcode.com/problems/find-total-time-spent-by-each-employee/submissions/
select event_day as 'day', emp_id, sum(out_time - in_time) as 'total_time' from Employees group by event_day, emp_id;

-- DAY 9

-- https://leetcode.com/problems/capital-gainloss/

-- https://leetcode.com/problems/top-travellers/submissions/
select u.name, case when e.travelled_distance is null then 0 else e.travelled_distance end as 'travelled_distance'
from Users u left outer join (
    select user_id, sum(distance) as 'travelled_distance' from Rides group by user_id
) e on u.id = e.user_id order by e.travelled_distance desc, u.name asc;

-- https://leetcode.com/problems/market-analysis-i/

-- DAY 10

-- https://leetcode.com/problems/duplicate-emails/submissions/
select email from Person group by email having count(email) > 1;

-- https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/submissions/
select actor_id, director_id from ActorDirector group by actor_id, director_id having count(timestamp) >= 3;

-- https://leetcode.com/problems/bank-account-summary-ii/submissions/
select u.name, e.balance from Users u inner join (select o.account, sum(o.amount) as 'balance' from Transactions o group by o.account having sum(o.amount) > 10000) e on u.account = e.account;

-- https://leetcode.com/problems/sales-analysis-iii/submissions/
select e.product_id, e.product_name from (select t.product_id, t.product_name, s.sale_date from Product t left outer join Sales s on t.product_id = s.product_id group by t.product_id having s.sale_date between '2019-01-01' and '2019-03-31') e;
