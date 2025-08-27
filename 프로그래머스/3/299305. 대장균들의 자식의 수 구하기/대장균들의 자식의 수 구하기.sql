select id, IFNULL(c.child_count, 0) as child_count from ECOLI_DATA e
left join (select parent_id, count(*) as child_count from ECOLI_DATA  where parent_id is not null group by parent_id) c 
on e.id = c.parent_id
order by e.id;
