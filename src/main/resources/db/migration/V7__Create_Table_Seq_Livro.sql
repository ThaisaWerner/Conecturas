CREATE TABLE IF NOT EXISTS `seq_livros` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO seq_livros (next_val) VALUES (1);