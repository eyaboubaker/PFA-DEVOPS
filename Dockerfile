# Use a small, Alpine-based image
FROM nginx:alpine

# Copy the project files into the nginx web root
COPY . /usr/share/nginx/html/

# Expose the default HTTP port
EXPOSE 80

# Command to run when the container starts
CMD ["nginx", "-g", "daemon off;"]
