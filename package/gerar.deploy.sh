#!/bin/sh

export VERSAO=3.10
export PACKAGE_NAME=F2IBuilder.$VERSAO.bin.all.zip

export RAIZ=/home/desenvolvimento/f2ibuilder
export RELEASE=$RAIZ/package/release/
export CURRENT=$RAIZ/package/current/


echo "Criando: F2IBuilder $VERSAO"
cd $CURRENT;
echo "    Criando pacote... (Zip - All)"
zip -rq4 $RELEASE/$PACKAGE_NAME * -x *SVN* *svnignore* *.svn*
echo "    Pacote Finalizado"

