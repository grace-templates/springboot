# Upgrade to Spring Boot 3.1, 3.2, 3.3

You can use this template to generate a new Grace application and upgrade it to Spring Boot 3.1, 3.2, 3.3, 3.4.

### How to Use?

Grace `2023.0.0` provides Application Template to allow developers customize the generated project by using `--template` flag.

You need install Grace 2023.0 first,

```bash
$ sdk install grace
```

then create a project with Spring Boot `3.3.5` and apply the `springboot` template,

```bash
$ grace create-app \
grace.apps.springboot \
--template https://github.com/grace-templates/springboot.git \
--boot-version=3.3.5 \
--enable-preview
```

or,

```bash
$ grace create-app \
grace.apps.springboot \
--template https://github.com/grace-templates/springboot/archive/refs/heads/main.zip \
--boot-version=3.3.5 \
--enable-preview
```

or, in your project root directory,

```bash
$ grace app:template \
--location https://raw.githubusercontent.com/grace-templates/springboot/main/scripts/post_apply_template.groovy \
--boot-version=3.3.5
```


### Support Versions

* Grace 2023.0.0+

### Grace 2023.1.0

Grace 2023.1.0-M2 has been released, this version has already built-in support specific Spring Boot version by using flag `boot-version`,
so you don't need use application template any more,

```bash
$ grace create-app \
grace.apps.springboot \
--boot-version=3.3.5
```

### Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace Guides](https://github.com/grace-guides)
