# DBMS_Project
University enrollment application


update enrolls e
set e.status = (Case when ((select c.current_enrollment from course_offering c,students s where e.OFFERING_id=c.OFFERING_id and e.student_id = s.student_id and  s.student_id = 123) < 
((select c.max_enrollment from course_offering c,students s where e.OFFERING_id=c.OFFERING_id and e.student_id = s.student_id and  s.student_id = 123))) then 'E' ELSE 'A' END);
