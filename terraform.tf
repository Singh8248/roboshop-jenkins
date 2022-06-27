provider "aws" {
  region = "us-east-1"
}

terraform {
  backend "s3" {
    bucket = "terraform-b64"
    key    = "jenkins-dns-record/terraform.tfstate"
    region = "us-east-1"
  }
}

data "aws_instance" "jenkins" {
  instance_id = "i-0ba2bdafd80c8bcc4"
}

resource "aws_route53_record" "jenkins" {
  zone_id = "Z03439621SCOB6CXGIDUM"
  name    = "jenkins.devopsb64.online"
  type    = "A"
  ttl     = "30"
  records = [data.aws_instance.jenkins.public_ip]
}

