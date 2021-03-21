#!/usr/bin/env sh

# Install antigen
curl -L git.io/antigen > $HOME/.antigen.zsh

# Update zshrc
sed -i 's/antigen.zsh/.antigen.zsh/' $HOME/.antigen.zsh

# zsh-completion
git clone https://github.com/zsh-users/zsh-completions ${ZSH_CUSTOM:=~/.oh-my-zsh/custom}/plugins/zsh-completions

# add plugins
sed -i 's/^plugins=.*/plugins=(git sudo zsh-completions zsh_reload)\nautoload -U compinit \&\& compinit/' $HOME/.zshrc

# remove default theme
sed -i 's/^ZSH_THEME="codespaces"$/#ZSH_THEME="codespaces"/' $HOME/.zshrc

# append to zshrc
cat << EOF >> $HOME/.zshrc

# Load Antigen
source $HOME/.antigen.zsh

# Load oh-my-zsh library.
antigen use oh-my-zsh

# Load bundles from external repos.
antigen bundle zsh-users/zsh-autosuggestions
antigen bundle zsh-users/zsh-syntax-highlighting

antigen theme denysdovhan/spaceship-prompt

# Tell Antigen that you're done.
antigen apply
EOF

# cat << EOF >> $HOME/.zshrc

# alias cjava="javac -cp \\\$(for i in \\\`ls /workspace/app/lib/*.jar\\\`; do echo -n "\\\$i:"; done). -d /workspace/app/bin \\\$(find /workspace/app/src/* | grep .java)"
# alias ejava="cd /workspace/app/bin && java -cp .:\\\$(for i in \\\`ls /workspace/app/lib/*.jar\\\`; do echo -n "\\\$i:"; done) server.Server -t && cd -"
# alias cejava="cjava && ejava"
# EOF

