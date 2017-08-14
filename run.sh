./gradlew -q runCodeGen \
   -Pclargs=--descriptor_set=../google-cloud-dotnet/tmp/protos.desc,\
--service_yaml=../google-cloud-dotnet/googleapis/google/datastore/v1/../datastore.yaml,\
--gapic_yaml=../google-cloud-dotnet/tmp/Google.Cloud.Datastore.V1/gapic.yaml,\
--output=tmp/Google.Cloud.Datastore.V1
