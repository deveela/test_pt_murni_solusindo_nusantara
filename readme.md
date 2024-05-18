Test PT Murni Solusindo Nusantara

Jawaban no. 1 - 6 ada di source code.

Jawaban no. 7 - 9 dibawah ini:

/* jawaban no. 7 */
select name, avg(score) as avg_score from emotions group by name;

/* jawaban no. 8 */
select
name
, concat(emotion, '(', count(1), ')') as modus
from
emotions
group by emotion, name
order by name;

/* jawaban no. 9 */
select
date(created) as tanggal
, name
, concat(emotion, '(', count(1), ')') as modus
, avg(score) as avg_score
from
emotions
group by emotion, name, date(created)
order by date(created), name;