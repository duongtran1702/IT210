DROP TABLE IF EXISTS student;

CREATE TABLE student (
	id VARCHAR(20) PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	faculty VARCHAR(100) NOT NULL,
	study_year INT NOT NULL,
	gpa DOUBLE NOT NULL
);

INSERT INTO student (id, name, faculty, study_year, gpa) VALUES
('SV001', 'Nguyen Van An', 'Cong nghe thong tin', 3, 8.5),
('SV002', 'Tran Thi Binh', 'Kinh te', 2, 7.2),
('SV003', 'Le Minh Cuong', 'Cong nghe thong tin', 4, 3.8);

