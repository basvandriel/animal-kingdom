INSERT INTO `elephant-animal-properties`
(`id`, `animal-properties-id`, `earsize`)
VALUES
  (NULL, '3', '787'),
  (NULL, '4', '2002');

INSERT INTO `animal-properties`
(`id`, `animal-type-id`, `gender-id`, `name`, `bodyCovering`, `color`, `weight`, `maxNumberOfEggs`)

VALUES
  (NULL, '4', '1', 'Hendrik', 'Olifantritus', 'black', '90', '2'),
  (NULL, '5', '2', 'Jan', '89', 'blue', '80', '20');

INSERT INTO `animal`
(`UUID`, `animal-properties-id`)

VALUES
  ('f597ba4f-c2bc-11e6-b033-089e01d221a8', '3'),
  ('f599a0ac-c2bc-11e6-b033-089e01d221a8', '4');
