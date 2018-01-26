data "terraform_remote_state" "core" {
  backend = "s3"
  config {
    bucket = "ovo-terraform-training"
    key = "core"
    region = "eu-west-1"
    profile = "training"
  }
}