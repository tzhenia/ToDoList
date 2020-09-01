CREATE TABLE `note` (
  `id` int(11) NOT NULL,
  `title` text,
  `details` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `note` VALUES
(1,'Todo task 1','Details 1'),
(2,'Todo task 2','Details 2');