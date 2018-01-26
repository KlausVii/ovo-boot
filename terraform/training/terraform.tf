terraform {
  backend "s3" {
    bucket = "ovo-terraform-training"
    key = "klaus"
    region = "eu-west-1"
    encrypt = true
    profile = "training"
    dynamodb_table = "ovo-tf-training-lock"
  }
}