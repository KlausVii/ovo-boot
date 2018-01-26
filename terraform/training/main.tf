resource "aws_instance" "server" {
  ami = "ami-d834aba1"
  instance_type = "t2.micro"
  subnet_id = "subnet-be8166d8"
  associate_public_ip_address = true
  vpc_security_group_ids = ["${aws_security_group.server.id}"]
  tags {
    Name = "${var.firstname}' House"
  }
  user_data = "${data.template_file.cloud_init.rendered}"
}

data "template_file" "cloud_init" {
  template = "${file("./cloud_init.tpf")}"
  vars {
    name = "${var.firstname}"
  }
}

resource "aws_security_group" "server" {
  name = "${var.firstname}-security-group"
  vpc_id = "vpc-042ce862"
  ingress {
    from_port = 8080
    to_port = 8080
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_route53_record" "server" {
  zone_id = "${data.terraform_remote_state.core.dns-zone-id}"
  name = "${var.firstname}"
  type = "A"
  ttl = 300
  records = ["${aws_instance.server.public_ip}"]
}